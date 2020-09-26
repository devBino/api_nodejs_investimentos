const Model = require('./model')

class Usuario extends Model{

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