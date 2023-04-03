CREATE TABLE marks
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE models
(
    id      BIGSERIAL PRIMARY KEY,
    name    TEXT NOT NULL,
    mark_id SERIAL         NOT NULL,
    FOREIGN KEY (mark_id)
        REFERENCES marks (id)
);

CREATE TABLE cars
(
    id           BIGSERIAL PRIMARY KEY,
    release_date DATE    NOT NULL,
    color        TEXT NOT NULL,
    model_id     BIGSERIAL     NOT NULL,
    FOREIGN KEY (model_id)
        REFERENCES models (id)
);