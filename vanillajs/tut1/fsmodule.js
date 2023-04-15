const fs = require('fs')


fs.readFile('myfile.txt', 'utf-8', (err, data)=>{
    console.log(err, data)
})
