-- Create the extension if it does not already exist
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS product_image (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    file_path TEXT,
    filename VARCHAR(255),
    product_id UUID,

    -- Auditing fields
    created_by VARCHAR(255),
    creation_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP
);
