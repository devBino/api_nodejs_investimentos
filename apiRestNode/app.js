let express     = require('express')
let consign     = require('consign')
let bodyParser  = require('body-parser')

let app = express()

app.use( bodyParser.urlencoded({extended:true}) )
app.use( bodyParser.json() )

consign()
    .include('app/routes')
    .into(app)


app.listen(3000,()=>{
    console.log('Servidor Rodando com sucesso!!')
})