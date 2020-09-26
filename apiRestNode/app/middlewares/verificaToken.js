const env   = require('../../env')

module.exports = (req,res,next) => {
    
    try{
        
        let jsonWebToken    = require('jsonwebtoken')
        var token           = req.headers['x-access-token']
        
        if (!token){
            res.status(401).send({
                error:true,
                message:'Token inválido...'
            })
        }
        
        jsonWebToken.verify(token, env.jwt, function(err, decoded) {
        
            if (err){
                res.status(401).send({
                    error:true,
                    message:'Token inválido...'
                })
            }
            
            req.userId = decoded.id;

        })
        
        if( req.userId != undefined && req.userId != null ){
            next()
        }else{
            res.status(401).send({
                error:true,
                message:'Token inválido...'
            })
        }

    }catch(e){
        res.status(401).send({
            error:true,
            message:'Token inválido...'
        })
    }
}