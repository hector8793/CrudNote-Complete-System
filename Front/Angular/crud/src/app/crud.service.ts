import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }

  public sendHeald() {
    return this.http.get('https://xdud8ybozg.execute-api.us-east-1.amazonaws.com/qa/campaign/query/v1/findMessages/14')
  }
}
