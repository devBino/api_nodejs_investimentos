<?php

use Illuminate\Support\Facades\Route;

Route::get('/ativos','Ativo@index');
Route::post('/ativos-salvar','Ativo@salvar');
Route::get('/ativos-deletar/{id}','Ativo@deletar');