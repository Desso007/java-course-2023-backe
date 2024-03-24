--changeset Desso:createBazTable
CREATE TABLE baz (
    id SERIAL PRIMARY KEY,
    value INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL
);
--rollback DROP TABLE baz;
