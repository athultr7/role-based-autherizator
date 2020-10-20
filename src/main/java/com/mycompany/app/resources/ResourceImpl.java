package com.mycompany.app.resources;

import java.util.Objects;

public class ResourceImpl implements Resource {

    private String resourceName;

    public ResourceImpl(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "ResourceImpl{" +
                "resourceName='" + resourceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceImpl)) return false;
        ResourceImpl resource = (ResourceImpl) o;
        return getResourceName().equals(resource.getResourceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResourceName());
    }
}
