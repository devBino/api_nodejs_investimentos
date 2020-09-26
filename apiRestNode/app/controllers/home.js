const httpCodes = require('../repositories/httpCodes')

class Home{

    inicio(req,res){

        httpCodes.response(
            {
                message:'Api Rest NodeJs para multi plataforma',
                success:true
            },
            200,
            res
        )

    }

}

module.exports = new Home()