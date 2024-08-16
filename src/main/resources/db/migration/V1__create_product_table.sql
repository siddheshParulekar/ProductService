-- Create the extension if it does not already exist
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create the table if it does not already exist
CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description TEXT,
    prize NUMERIC(15, 2),
    condition VARCHAR(255),
    category VARCHAR(255) DEFAULT 'UNISEX',
    sub_category VARCHAR(255) DEFAULT 'OTHERS',
    brand VARCHAR(255),
    seller_id BIGINT,
    prod_status VARCHAR(255) DEFAULT 'IN_STOCK',
    approval_status VARCHAR(255) DEFAULT 'PENDING',
    size VARCHAR(255) DEFAULT 'FREE_SIZE',
    colour VARCHAR(255) DEFAULT 'OTHER',

    -- Auditing fields
    created_by VARCHAR(255),
    creation_date TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP
);