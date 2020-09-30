<?php

use Illuminate\Support\Facades\Route;

//SISTEMA
Route::get('/sistema','Sistema@index')->middleware(['IsOk']);