package com.apress.springbatch.chapter7;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider;
import org.springframework.util.Assert;

public class CustomerByCityQueryProvider extends AbstractJpaQueryProvider {
    
    private String cityName;
    
    public Query createQuery() {
        EntityManager manager = getEntityManager();
        
        Query query = manager.createQuery("select c from Customer c where c.city = :city");
        query.setParameter("city", cityName);
        
        return query;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cityName);
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
