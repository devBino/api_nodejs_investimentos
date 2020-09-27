const httpCodes = require('../repositories/httpCodes')
const mdUsuario = require('../models/usuario')

class Usuario{

    async listar(req,res){
        try{
            let lista   = await mdUsuario.listar()
            httpCodes.response(lista,200,res)
        }catch(e){
            httpCodes.responseErro(res)
        }
    }

    

}

module.exports = new Usuario()