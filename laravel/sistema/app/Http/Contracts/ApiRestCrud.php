<?php
namespace App\Http\Contracts;

interface ApiRestCrud{

    public static function listar();
    public static function salvar($params);
    public static function alterar($params);
    public static function deletar($id);

}