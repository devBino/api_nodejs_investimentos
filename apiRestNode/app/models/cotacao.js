const nodeFetch = require('node-fetch')
const paramsApi = require('../repositories/paramsApi')

class Cotacao{

    async getCotacaoAtivo(req){
    
        try{
            
            let url = paramsApi.getUrlCotacao(req.params.ativo)
            let resposta = await nodeFetch(url);
            
            let dadosAtivo = await resposta.json();

            return {data:dadosAtivo,message:'Consulta efetuada com sucesso...',success:true}
            
        }catch(e){
            return {data:undefined,message:'Erro ao tentar Consutar Api de Cotações...',success:false}
        }
    
    }

}

module.exports = new Cotacao()