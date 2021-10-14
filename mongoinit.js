db.createCollection("movie")
db.movie.createIndex({"title":1},{unique:true, sparse:true})
