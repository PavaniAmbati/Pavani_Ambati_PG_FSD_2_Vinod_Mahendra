package com.simplilearn.workshop.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.simplilearn.workshop.model.FlightRoute;
import com.simplilearn.workshop.model.FlightSchedule;
public class HibernateUtils {
	
	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        
        if (sessionFactory == null) {
            try {

                registry = new StandardServiceRegistryBuilder().configure().build(); // load hibernate.cfg.xml
                
                MetadataSources sources = new MetadataSources(registry);
                
                Metadata metadata = sources.getMetadataBuilder().build();
                
                sessionFactory = metadata.getSessionFactoryBuilder().build(); 
            }catch(Exception e) {
                e.printStackTrace();
                if ( registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                    
                }
            }
        }
        return sessionFactory;
    }

}