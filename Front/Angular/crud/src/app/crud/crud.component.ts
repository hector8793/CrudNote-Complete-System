import { Component, OnInit } from '@angular/core';
import { CrudService } from '../crud.service';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss']
})
export class CrudComponent implements OnInit {

  constructor(private crudService: CrudService) { }

  ngOnInit() {
    this.crudService.sendHeald().subscribe((resp)=>{
      console.log(resp);
    })
  }

}
