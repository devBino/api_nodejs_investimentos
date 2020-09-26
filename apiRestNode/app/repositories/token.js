const jsonWebToken  = require('jsonwebtoken')
const env           = require('../../env')

class Token{

    gerar(dadosUsuario){
        return new Promise((resolve,reject)=>{
            try{
                if( dadosUsuario.length > 0 ){
                    const id = dadosUsuario[0].cdUsuario
        
                    var token = jsonWebToken.sign({ id }, env.jwt, {
                        expiresIn: 3600
                    })
                      
                    resolve({ auth: true, token: token })
        
                }else{
                    reject({token:undefined})
                }

            }catch(e){
                reject({token:undefined})
            }
        })
    }

}

module.exports = new Token()