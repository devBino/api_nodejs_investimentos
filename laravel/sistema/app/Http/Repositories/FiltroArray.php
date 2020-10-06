<?php
namespace App\Http\Repositories;

use Exception;

class FiltroArray{

    public static function filtrarResultadoChaves($arrayParam, $arrChaves){

        try{

            $array = (array) $arrayParam;
            
            foreach($arrChaves as $num => $chave){
                if( isset($array[$chave]) ){
                    $array = (array) $array[$chave];
                }
            }

            return ['array'=>$array];

        }catch(Exception $e){
            return ['array'=>null];
        }


    }

}