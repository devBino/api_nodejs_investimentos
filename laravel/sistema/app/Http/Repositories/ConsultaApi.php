<?php
namespace App\Http\Repositories;

use Exception;

/**
 * @author Fernando Bino
 * @see Classe responsavel por consultas na Api Rest Node
 * coisas comuns que se repetem na chamada curl estão padronizadas aqui 
 * e podem a estrategia pode ser reaproveitada no sistema
 * 
 * @example
 * Existe um modelo de implementação em:
 * 
 * App\Http\Contracts\ApiRestCrud => estabelece o que deve ser implementado em
 * App\Http\Models\TipoAtivoData => que por sua vez não depende de App\Http\Repositories\ConsultaApi
 * mas como App\Http\Models\TipoAtivoData está extendendo App\Http\Models\Model, toda regra está contida em 
 * Model
 * 
 * Assim a criação de novas classes iguais a App\Http\Models\TipoAtivoData podem ser feitas apenas replicando o padrão,
 * independente de App\Http\Repositories\ConsultaApi e App\Http\Models\Model
*/

class ConsultaApi{
    
    private static $url;
    private static $params  = null;
    private static $metodo  = "GET";
    private static $token   = null;
    private static $headers = array();



    /**
     * @example ConsultaApi::headers('x-access-token: valor_token')
    */
    public static function headers($param = 'content-type: application/json'){
        array_push(self::$headers, $param);
    }

    /**
     * @example ConsultaApi::cleanHeaders() 
    */
    public static function cleanHeaders(){
        self::$headers = array();
    }


    /**
     * @example ConsultaApi::setMetodo('POST')
    */
    public static function setMetodo($paramMetodo){
        self::$metodo = $paramMetodo;
    }



    /**
     * @example ConsultaApi::setUrl('http://localhost:3000/produtos')
    */
    public static function setUrl($paramUrl){
        self::$url = $paramUrl;
    }



    /**
     * @example ConsultaApi::setParams(['nmTipo'=>'Renda Fixa'])
     * 
     * @see https://documenter.getpostman.com/view/9798213/TVKHUvUi
     *      Verificar documentação da Api Rest NodeJs
    */
    public static function setParams($paramsRequest){
        self::$params = $paramsRequest;
    }

    /**
     * @see Verifica se os parametros necessários para consulta estão setados
     * caso não, dispara Exceção
    */
    public static function validaConsulta(){
        
        if( empty(self::$url) || is_null(self::$url) ){
            throw new Exception("Url deve ser informada, use ConsultaApi::setUrl('stringUrl')");
        }

        if( empty(self::$metodo) || is_null(self::$metodo) ){
            throw new Exception("Metodo deve ser GET,POST,PUT ou DELETE, use ConsultaApi::setMetodo('nomeMetodo')");
        }

        if( in_array( strtoupper(self::$metodo),['POST','PUT'] ) ){
            if( !is_array(self::$params) || !count(self::$params) ){
                throw new Exception("Para metodos POST e PUT um array com parâmetros deve ser passado usando ConsultaApi::setParams(array())");
            }
        }

        if( !count(self::$headers) ){
            throw new Exception("É necessário informar os headers, para adicionar header deve usar ConsultaApi::headers('string_header')");
        }

        return true;
    }

    /**
     * @example ConsultaApi::consultar()
     * 
     * @see consulta Api de acordo com paramtros setados
    */
    public static function consultar(){
        
        if( self::validaConsulta() ){
            $executaMetodo = "execute".self::$metodo;
            return self::$executaMetodo();
        }

    }

    /**
     * @see 
     * Abaixo funções para os respectivos metodos HTTP
     * GET,POST,PUT e DELETE
    */

    public static function executePOST(){

        self::headers();

        $jsonParams = json_encode(self::$params);

        $curl = curl_init();

        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONNECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "POST",
            CURLOPT_POSTFIELDS => $jsonParams,
            CURLOPT_HTTPHEADER => self::$headers
        ));

        $response   = curl_exec($curl);
        $err        = curl_error($curl);

        curl_close($curl);

        if ($err) {
            $return = ['msg'=>$err];
        } else {
            $return = ['success'=>true,'msg'=>'Curl Executada com sucesso!','response'=>$response];
        }

        return $return;
    }

    public static function executeGET(){
        
        self::headers();
        
        $curl = curl_init();
        
        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONNECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "GET",
            CURLOPT_HTTPHEADER => self::$headers
        ));

        $response   = curl_exec($curl);
        $err        = curl_error($curl);

        curl_close($curl);

        if ($err) {
            $return = ['msg'=>$err,'success'=>false];
        } else {
            $return = ['success'=>true,'msg'=>'Curl Executada com sucesso!','response'=>$response];
        }

        return $return;
    }

    public static function executeDELETE(){
        
        self::headers();

        $curl = curl_init();
        
        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONNECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "DELETE",
            CURLOPT_HTTPHEADER => self::$headers
        ));

        $response   = curl_exec($curl);
        $err        = curl_error($curl);

        curl_close($curl);

        if ($err) {
            $return = ['msg'=>$err,'success'=>false];
        } else {
            $return = ['success'=>true,'msg'=>'Curl Executada com sucesso!','response'=>$response];
        }

        return $return;
    }


    public static function executePUT(){

        self::headers();

        $jsonParams = json_encode(self::$params);

        $curl = curl_init();

        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONNECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "PUT",
            CURLOPT_POSTFIELDS => $jsonParams,
            CURLOPT_HTTPHEADER => self::$headers
        ));

        $response   = curl_exec($curl);
        $err        = curl_error($curl);

        curl_close($curl);

        if ($err) {
            $return = ['msg'=>$err];
        } else {
            $return = ['success'=>true,'msg'=>'Curl Executada com sucesso!','response'=>$response];
        }

        return $return;
    }


}