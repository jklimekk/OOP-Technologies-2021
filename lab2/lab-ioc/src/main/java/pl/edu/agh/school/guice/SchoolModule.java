package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import pl.edu.agh.school.persistence.PersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {

    @Provides
    PersistenceManager providePersistenceManager(SerializablePersistenceManager serializablePersistenceManager) {
        return serializablePersistenceManager;
    }

    @Provides
    @Named("teachers")
    private String provideTeachersFilename() {
        return "xdd.dat";
    }
}
