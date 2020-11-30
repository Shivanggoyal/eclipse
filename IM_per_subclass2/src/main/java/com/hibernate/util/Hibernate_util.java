package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate_util {

	private static StandardServiceRegistry standardRegistry;
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try
			{
				standardRegistry=new StandardServiceRegistryBuilder().configure().build();//read the information from hibernate.cfg.xml and establish a connection with the database
				MetadataSources sources=new MetadataSources(standardRegistry);//
				Metadata metadata=sources.getMetadataBuilder().build();
				sessionFactory=metadata.getSessionFactoryBuilder().build();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				if(standardRegistry!=null)
				{
					StandardServiceRegistryBuilder.destroy(standardRegistry);
				}
			}
		}
		return sessionFactory;
	}
}
