/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izv.modelo;

import com.izv.hibernate.Fotos;
import com.izv.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author AngelakaMogu
 */
public class ModeloFoto {
    
     public static List <Fotos> getAll(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM Fotos F WHERE F.idinmueble = "+id;
        Query q = session.createQuery(hql);
        List<Fotos> fotos = q.list();
        session.getTransaction().commit();
        session.close();
        return fotos;
    }
    
    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Fotos fot = (Fotos) session.load(Fotos.class,Integer.parseInt(id));
        session.delete(fot);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Fotos inm){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(inm);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Fotos fot){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(fot);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static Fotos get(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Fotos fot = (Fotos) session.get(Fotos.class, Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        
        return fot;
    }
    
}
