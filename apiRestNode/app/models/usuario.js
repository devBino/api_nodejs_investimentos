const Model = require('./model')

class Usuario extends Model{

    constructor(){
        super()
        this.setSqlQuery()
        this.campos = ['cdUsuario','nmUsuario','dsSenha','dsEmail','cdPermissao','cdStatus']
    }

    setSqlQuery(){
        this._sqlQuery = 'select cdUsuario,nmUsuario,dsEmail,cdPermissao,cdStatus from usuario'
    }

    async checarCredencial(req){
        try{
            
            let sql = `select * from usuario where nmUsuario="${req.params.usuario}" and dsSenha="${req.params.senha}" `
            let dadosUsuario    = await this._Db.executeQuery(sql)
            
            return dadosUsuario
        }catch(e){
            return {data:undefined,message:'Credenciais inválidas',success:false}
        }        
    }
    

}

module.exports = new Usuario()