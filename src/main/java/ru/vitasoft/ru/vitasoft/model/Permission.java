package ru.vitasoft.ru.vitasoft.model;

public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_UPDATE("user:update");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
