CREATE TYPE todo_status AS ENUM ('inProgress', 'done');

CREATE TABLE IF NOT EXISTS tasks (
    id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(256) NOT NULL,
    status todo_status DEFAULT 'inProgress'
);
