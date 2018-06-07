/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Categories;
import entity.Products;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author exam
 */
public class CategoryProductDAO {
    SessionFactory sessionFactory;
    
    public List<Categories> getAllCategories(){
        try {
            sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Categories");
            List list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
 
    }
    
    public static void main(String[] args) {
        CategoryProductDAO ct = new CategoryProductDAO();
        for(Categories c: ct.getAllCategories()){
            System.out.println(c.getCategoryID());
        }
    }
    
    
    public List<Products> getProductByCategoryId(String cateId){
        try {
            sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Products where categoryID.categoryID=?");
            query.setString(0, cateId);
            List list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
}
