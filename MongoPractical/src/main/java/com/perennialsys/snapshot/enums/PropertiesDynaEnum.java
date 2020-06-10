package com.perennialsys.snapshot.enums;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;


public class PropertiesDynaEnum extends DynaEnum<PropertiesDynaEnum> {
    protected PropertiesDynaEnum(String name, int ordinal) {
        super(name, ordinal);
    }

    public static <E> DynaEnum<? extends DynaEnum<?>>[] values() {
        return values(PropertiesDynaEnum.class);
    }

    protected static <E> void init(Class<E> clazz) {
        try {
            initProps(clazz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private static <E> void initProps(Class<E> clazz) throws Exception {


        String rcName = clazz.getSimpleName() + ".properties";
        System.out.println("File path - " + rcName);

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classloader.getResourceAsStream(rcName);
        InputStreamReader strReader = new InputStreamReader(resourceAsStream);


        BufferedReader reader = new BufferedReader(strReader);

        Constructor<E> minimalConstructor = getConstructor(clazz, new Class[]{String.class, int.class});
        Constructor<E> additionalConstructor = getConstructor(clazz, new Class[]{String.class, int.class, Class.class});
        Constructor<E> twoValueConstructor = getConstructor(clazz, new Class[]{String.class, int.class, Class.class, String.class});
        int ordinal = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            line = line.replaceFirst("#.*", "").trim();
            if (line.equals("")) {
                continue;
            }
            String[] parts = line.split("\\s*=\\s*");
            if (parts.length == 1 || (additionalConstructor == null && twoValueConstructor == null)) {
                minimalConstructor.newInstance(parts[0], ordinal);
            } else if (parts.length == 2) {
                additionalConstructor.newInstance(parts[0], ordinal, Class.forName(parts[1]));
            } else {
                twoValueConstructor.newInstance(parts[0], ordinal, Class.forName(parts[1]), parts[2]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <E> Constructor<E> getConstructor(Class<E> clazz, Class<?>[] argTypes) {
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            try {
                return (Constructor<E>) c.getDeclaredConstructor(argTypes);
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
}

