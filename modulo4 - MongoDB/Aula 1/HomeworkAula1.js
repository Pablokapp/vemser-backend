Criar database e Collection tindev user
> use tindev
> db.createCollection("tindev_user")

Ou inserindo direto um document  > já cria o banco tindev a collection tindev_user e faz a inserção do document
> db.tindev_user.insert({ "username" : "pedro","password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3",	"proglangs" : "PHP","gender" : "MALE","pref" : "BOTH","role" : 1})

InsertMany
db.tindev_user.insertMany([
{"username" : "jose", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "PHP", "gender" : "MALE", "pref" : "BOTH", "role" : 1 },
{"username" : "antonio", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "RUBY", "gender" : "MALE", "pref" : "BOTH", "role" : 2},
{"username" : "carlos", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "DART", "gender" : "MALE", "pref" : "BOTH", "role" : 1 },
{"username" : "maria", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "RUST", "gender" : "MALE", "pref" : "BOTH", "role" : 2 },
{"username" : "fernanda", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "JAVA", "gender" : "MALE", "pref" : "BOTH", "role" : 1 }
])
UpdateOne
```
db.tindev_user.updateOne ({ username: "fernanda" },   {  $set: { "proglangs" : "PHP" }})
```

UpdateMany
db.tindev_user.updateMany ( {"role":  2 } ,    {$set :  {"cargo" : "userPro"  }} )

Find
db.tindev_user.find()
db.tindev_user.find("role":"1")

Find Or
db.tindev_user.find(  { $or : [ { "role" : 1}, {"role" : 2   }  ]   }  )

Find In 
db.tindev_user.find({ "role" : {   $in : [1,2] } })

Delete
db.tindev_user.deleteOne({  "username" : "fernanda" })