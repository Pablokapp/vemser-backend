-- Aula 2 --

db.tindev_user.insertOne([ {"username" : "jose Pedro", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "PHP", "gender" : "MALE", "pref" : "BOTH", "role" : 1  }])

db.tindev_user.insertMany([
{"username" : "jose", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "PHP", "gender" : "MALE", "pref" : "BOTH", "role" : 1 },
{"username" : "antonio", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "RUBY", "gender" : "MALE", "pref" : "BOTH", "role" : 2},
{"username" : "carlos", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "DART", "gender" : "MALE", "pref" : "BOTH", "role" : 1 },
{"username" : "maria", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "RUST", "gender" : "MALE", "pref" : "BOTH", "role" : 2 },
{"username" : "fernanda", "password" : "1e2dcad68462352feeb8bf633deaccfb8aa84f3", "proglangs" : "JAVA", "gender" : "MALE", "pref" : "BOTH", "role" : 1 }
])

Delete
db.tindev_user.deleteOne({  "username" : "fernanda" })

Find Equal
db.tindev_user.find({"username": "maria" , "proglangs":"RUST"})

Find AND
db.tindev_user.find ( { "role": {$lt:2}, "pref":"BOTH"  }    )

Find Or
db.tindev_user.find(  { $or : [ { "role" : 1}, {"role" : 2   }  ]   }  )

Find In 
db.tindev_user.find({ "role" : {   $in : [1,2] } })

Find Expressão
db.tindev_user.find({ "username": /^j/ } )

Find Aninhado
db.tindev_user.find  ({ "username.proglangs": "PHP"})

UpdateOne
```
db.tindev_user.updateOne ({ username: "fernanda" },   {  $set: { "proglangs" : "PHP" }})
```

UpdateMany
db.tindev_user.updateMany ( {"role":  2 } ,    {$set :  {"cargo" : "userPro"  }} )