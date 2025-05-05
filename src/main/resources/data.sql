INSERT INTO user (id, first_name, last_name, created_at, updated_at)
VALUES ('7c451687-c96a-4b56-b32d-2a2f5c0e7352', 'Fredy', 'Martinez', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ticket (id, description, status, user_id, created_at, updated_at)
VALUES ('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'Ticket de ejemplo numero Uno', 'CLOSED', '7c451687-c96a-4b56-b32d-2a2f5c0e7352', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ticket (id, description, status, user_id, created_at, updated_at)
VALUES ('b2c3d4e5-f6a7-8901-bcde-f234567890ab', 'Ticket de ejemplo numero DOS', 'OPEN', '7c451687-c96a-4b56-b32d-2a2f5c0e7352', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
