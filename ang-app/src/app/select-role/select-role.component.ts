import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
// import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-select-role',
  templateUrl: './select-role.component.html',
  styleUrls: ['./select-role.component.css'],
})
export class SelectRoleComponent {
  email!: string;
  name!: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params: { [x: string]: string; }) => {
      this.email = params['email'];
      this.name = params['name'];

      if (!this.email || !this.name) {
        console.error('Missing query parameters. Redirecting to home.');
        this.router.navigate(['/']); // Redirect to home if parameters are missing
      }
    });
  }

  onRoleSelect(role: string): void {
    this.http
      .post('http://localhost:8080/api/save-role', {
        email: this.email,
        name: this.name,
        role,
      })
      .subscribe(() => {
        this.router.navigate([`${role}-dashboard`]);
      });
  }
}
