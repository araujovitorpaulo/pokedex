CREATE TABLE pokemons (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    number VARCHAR(100),
    name VARCHAR(100),
    type VARCHAR(100),
    image VARCHAR(255)
);