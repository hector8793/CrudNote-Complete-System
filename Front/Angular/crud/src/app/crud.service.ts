import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  private select_api = 0
  private api: [
    {
      lenguaje:"node",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"java",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"netcore",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"php",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"python",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"go",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    },
    {
      lenguaje:"ruby",
      getAll:""
      get:"",
      post:"",
      put:"",
      delete:""
    }
  ]

  constructor(private http: HttpClient) { }

  public sendHeald() {
    return this.http.get('https://xdud8ybozg.execute-api.us-east-1.amazonaws.com/qa/campaign/query/v1/findMessages/14')
  }

  public getUser(){
    return this.http.get(this.api[this.select_api].get + '')
  }

  public getAllUser(){
    return this.http.get(this.api[this.select_api].getAll + '')
  }

  public put(){
    return this.http.get(this.api[this.select_api].put + '')
  }
}
