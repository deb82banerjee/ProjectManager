import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task';
import { map, catchError } from 'rxjs/operators';
import { BaseService } from './base.service';
import { ParentTask } from '../models/parentTask';

@Injectable()
export class TaskService extends BaseService {
    constructor(private http: Http) {
        super();
    }

    getParentTask(): Observable<ParentTask[]> {
        return this.http.get(super.baseurl() + 'api/task/parent')
            .pipe(map((res: Response) => {
                const data = super.extractData(res);
                return data;
            }))
            .pipe(catchError(this.handleError));
    }
    addTask(task:Task): Observable<any> {
        debugger;
        return this.http.post(super.baseurl() + 'api/task/add',task)
            .pipe(map((res: Response) => {
                const data = super.extractData(res);
                return data;
            }))
            .pipe(catchError(this.handleError));
    }

    getAllTasksByProjectId(projectId:number):Observable<Task[]>{
        debugger;
        return this.http.get(super.baseurl() + 'api/task/retrieveTask?projectId='+projectId)
        .pipe(map((res: Response) => {
            const data = super.extractData(res);
            return data;
        }))
        .pipe(catchError(this.handleError));
    }

    updateTask(task:Task): Observable<any> {
        return this.http.post(super.baseurl() + 'api/task/update',task)
            .pipe(map((res: Response) => {
                const data = super.extractData(res);
                return data;
            }))
            .pipe(catchError(this.handleError));
    }

    deleteTask(task:Task): Observable<any> {
        return this.http.post(super.baseurl() + 'api/task/delete',task)
            .pipe(map((res: Response) => {
                const data = super.extractData(res);
                return data;
            }))
            .pipe(catchError(this.handleError));
    }
}   