import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { SelectRoleComponent } from './select-role/select-role.component';
import { FreelancerDashboardComponent } from './freelancer-dashboard/freelancer-dashboard.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'select-role', component: SelectRoleComponent },
  { path: 'freelancer-dashboard', component: FreelancerDashboardComponent },
  { path: 'client-dashboard', component: ClientDashboardComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
