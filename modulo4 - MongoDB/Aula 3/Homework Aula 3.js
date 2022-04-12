-- Aula 3 --
Find Ordenado
db.tindev_user.find({
    progLangs: "JAVA"
}).sort("username")


Find Limite
db.tindev_user.find ({ role: { $gte: 1} }).sort("nome").limit(2)

Ordem Exata
db.tindev_user.find ({ proglangs: ["PHP", "JAVA"] })

Condição múltipla
db.tindev_user.find( { "tindev_user.age": { $gt: 18, $lt: 30 } } )

Contém
db.tindev_user.find ({ proglangs: {$all: ["PHP", "JAVA"] }})

Aggregate
db.tindev_user.aggregate( [      {  $match: {  proglangs: "PHP"    }     }  ,  { $group: { _id: "$proglangs",  age: { $sum: "tindev_user.age" }   }} ])


