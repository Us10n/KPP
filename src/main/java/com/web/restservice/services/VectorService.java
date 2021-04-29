package com.web.restservice.services;

import com.web.restservice.controllers.MainController;
import com.web.restservice.entities.Cache;
import com.web.restservice.entities.Vector;
import com.web.restservice.entities.VectorBody;
import com.web.restservice.repository.VectorRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

@Service
public class VectorService {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    VectorRepo vectorRepo;

    @Autowired
    Cache cache;

    Semaphore semaphore = new Semaphore(1);

    public Vector dbVectorFind(VectorBody vectorBody){
        Vector vector;
        try {
            semaphore.acquire();
            vector=vectorRepo.findVectorByX1AndX2AndY1AndY2(vectorBody.getX1(), vectorBody.getX2(), vectorBody.getY1(), vectorBody.getY2());
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
            return null;
        }
        finally {
            semaphore.release();
        }
        return vector;
    }

    public Vector dbVectorSave(Vector vector){
        Vector vtmp;
        try {
            semaphore.acquire();
            vtmp=vectorRepo.save(vector);
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
            return null;
        }
        finally {
            semaphore.release();
        }
        return vtmp;
    }

    public List<Vector> convertToVectorList(List<VectorBody> vectorBodyList){
        return vectorBodyList.stream()
                .map((body) -> new Vector(body.getX1(), body.getY1(), body.getX2(), body.getY2()))
                .collect(Collectors.toList());
    }

    public List<VectorBody> VectorSaveList(List<VectorBody> vectorBodyList){
        try {
            vectorBodyList.forEach((vectorBody) -> {
                Vector vector;
                if (cache.isContains(vectorBody)) {
                    logger.info("Vector exists in cache");
                    vector = cache.get(vectorBody);

                    vector = this.dbVectorFind(vectorBody);
                    if (vector == null) {
                        logger.info("Vector saved in db");
                        //vector = new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                        vector=this.dbVectorSave(new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2()));
                    }
                } else {
                    vector = this.dbVectorFind(vectorBody);
                    if (vector != null) {
                        logger.info("Vector exists in db");
                    } else {
                        logger.info("Vector saved in db");
                        //vector = new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                        vector=this.dbVectorSave(new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2()));
                    }
                    logger.info("Vector saved cache");
                    cache.put(vectorBody, vector);
                }
            });
        }catch(Exception e){
            return null;
        }
        return vectorBodyList;
    }

    public Vector VectorSaveClass(VectorBody vectorBody){
        Vector vector;
        try {
            if (cache.isContains(vectorBody)) {
                logger.info("Vector exists in cache");
                vector = cache.get(vectorBody);

                vector = this.dbVectorFind(vectorBody);
                if (vector == null) {
                    logger.info("Vector saved in db");
                    //vector = new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                    vector=this.dbVectorSave(new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2()));
                }
            } else {
                vector = this.dbVectorFind(vectorBody);
                if (vector != null) {
                    logger.info("Vector exists in db");
                } else {
                    logger.info("Vector saved in db and cache");
                    //vector = new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                    vector=this.dbVectorSave(new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2()));
                }
                vector = new Vector(vectorBody.getX1(), vectorBody.getY1(), vectorBody.getX2(), vectorBody.getY2());
                logger.info("Vector saved cache");
                cache.put(vectorBody, vector);
            }
        }catch (Exception e){
            return null;
        }
        return vector;
    }

}
