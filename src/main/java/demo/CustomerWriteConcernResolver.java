package demo;

import com.mongodb.WriteConcern;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.WriteConcernResolver;

public class CustomerWriteConcernResolver implements WriteConcernResolver {

    @Override
    public WriteConcern resolve(MongoAction action) {

        System.out.println("Get write concern:" + action.getDefaultWriteConcern());
        System.out.println("Get entity type: " + action.getEntityType());
        System.out.println();

        return WriteConcern.JOURNALED;
    }
}
