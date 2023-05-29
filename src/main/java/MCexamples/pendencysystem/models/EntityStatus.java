package MCexamples.pendencysystem.models;

public enum EntityStatus {

    STARTED("STARTED"),
    STOPPED("STOPPED");

    private final String entity_status_string;

    EntityStatus(String entity_status_string) {
        this.entity_status_string = entity_status_string;
    }
}
