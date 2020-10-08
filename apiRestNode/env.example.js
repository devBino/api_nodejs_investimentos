let env = {
    debug:true,
    con:{
        host:'nome_host',
        user:'nome_usuario_host',
        password:'senha_host',
        database:'nome_banco_de_dados'
    },
    jwt:'palavra_passe_token',
    chaveApiCotacoes:'API_KEY' //API KEY em uma API externa usada nesse projeto
                            //   obter API_KEY EM https://hgbrasil.com/status/finance
}

module.exports = env