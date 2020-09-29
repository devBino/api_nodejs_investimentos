<?php
namespace App\Http\Repositories;

class ConsultaApi{
    
    private static $url;
    private static $params;
    private static $metodo;

    public function __construct(){
        self::$url      = null;
        self::$params   = null;
        self::$metodo   = "GET";
    }

    public static function setMetodo($paramMetodo){
        self::$metodo = $paramMetodo;
    }

    public static function setUrl($paramUrl){
        self::$url = $paramUrl;
    }

    public static function setParams($paramsRequest){
        self::$params = $paramsRequest;
    }


    public static function consultar(){
        $executaMetodo = "execute".self::$metodo;
        return self::$executaMetodo();
    }
    
    public static function executePOST(){
        $jsonParams = json_encode(self::$params);

        $curl = curl_init();

        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "POST",
            CURLOPT_POSTFIELDS => $jsonParams,
            CURLOPT_HTTPHEADER => array(
                'content-type: application/json'
            )
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
        
        $curl = curl_init();

        curl_setopt_array($curl,array(
            CURLOPT_URL => self::$url,
            CURLOPT_SSL_VERIFYPEER => 0,
            CURLOPT_SSL_VERIFYHOST => 0,
            CURLOPT_TIMEOUT => 15,
            CURLOPT_CONNECTTIMEOUT => 10,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_CUSTOMREQUEST => "GET",
            CURLOPT_HTTPHEADER => array(
                'content-type: application/json'
            )
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