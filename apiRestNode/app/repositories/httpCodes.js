class HttpCodes{

    response(data,code,res){
        res.status(code).send(data)
    }

    responseErro(res){
        res.status(500).send({data:{},message:'Erro ao processar requisição',success:false})
    }

}

module.exports = new HttpCodes()