--changeset Desso:createBarTable
CREATE TABLE bar (
    id SERIAL PRIMARY KEY,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL
);
--rollback DROP TABLE bar;
