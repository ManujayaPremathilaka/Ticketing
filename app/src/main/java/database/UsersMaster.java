package database;

import android.provider.BaseColumns;

public final class UsersMaster {

    private UsersMaster() {
    }

    public static class User implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String NAME = "name";
        public static final String PASSWORD = "password";
        public static final String TYPE = "type";
    }

    public static class Message implements BaseColumns{
        public static final String TABLE_NAME = "message";
        public static final String USER = "user";
        public static final String SUBJECT = "subject";
        public static final String MESSAGE = "message";
    }
    public static class Teacher implements BaseColumns{
        public static final String TABLE_NAME = "teacher";
        public static final String NAME = "name";
        public static final String PASSWORD = "password";
        public static final String TYPE = "type";
    }
}
