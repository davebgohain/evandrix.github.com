package org.gephi.desktop.neo4j;


import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.Icon;
import org.netbeans.swing.dirchooser.spi.CustomDirectoryProvider;
import org.openide.util.lookup.ServiceProvider;


/**
 *
 * @author Martin Škurla
 */
@ServiceProvider(service=CustomDirectoryProvider.class)
public class Neo4jCustomDirectoryProvider implements CustomDirectoryProvider {
    private static final Set<String> NEO4J_REQUIRED_FILE_NAMES;

    private static boolean enabled = false;


    static {
        String[] requiredFileNames =
            {"neostore",                                "neostore.id",
             "neostore.nodestore.db",                   "neostore.nodestore.db.id",
             "neostore.propertystore.db",               "neostore.propertystore.db.id",
             "neostore.propertystore.db.arrays",        "neostore.propertystore.db.arrays.id",
             "neostore.propertystore.db.index",         "neostore.propertystore.db.index.id",
             "neostore.propertystore.db.index.keys",    "neostore.propertystore.db.index.keys.id",
             "neostore.propertystore.db.strings",       "neostore.propertystore.db.strings.id",
             "neostore.relationshipstore.db",           "neostore.relationshipstore.db.id",
             "neostore.relationshiptypestore.db",       "neostore.relationshiptypestore.db.id",
             "neostore.relationshiptypestore.db.names", "neostore.relationshiptypestore.db.names.id"};

        NEO4J_REQUIRED_FILE_NAMES = new LinkedHashSet<String>(Arrays.asList(requiredFileNames));
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enable) {
        Neo4jCustomDirectoryProvider.enabled = enable;
    }

    @Override
    public boolean isValidCustomDirectory(File directory) {
        if (!directory.isDirectory())
            return false;

        int existingRequiredFiles = 0;
        for (File file : directory.listFiles()) {
            if (NEO4J_REQUIRED_FILE_NAMES.contains(file.getName()))
                existingRequiredFiles++;
        }

        return existingRequiredFiles == NEO4J_REQUIRED_FILE_NAMES.size();
    }

    @Override
    public Icon getCustomDirectoryIcon() {
        return ImageLoader.loadImage(ImageLoader.NEO4J_FILE_PATH);
    }
}
