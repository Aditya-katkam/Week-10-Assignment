package com.nichi.Week_10_Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="RETAILER")
public class Retailer {

    	@Column(name="RETAILER_ID")
    	@Id // primary key
    	@GeneratedValue(strategy = GenerationType.AUTO)
		public int retailer_id;
    	
        @NotNull (message = "Retailer name cannot be empty")
        @Size(min=8,max = 12, message = "Retailer name should be atleast 8 chars and atmost 12 chars")
        @Column(name="NAME")    	
	    public String name;
        
        @Min(1)
        @Max(value=99, message="Max age cannot be more than 99")
	    public int age;

        @NotBlank
        @Pattern(regexp = "^(.+)@(\\S+)$")
        public String email;
        
        @Column(name="YEARS_OF_EXPERIENCE")
        public float yearsOfExperience;
	    
	    public Retailer(String name, int age, float yearsOfExperience) {
	        this.name = name;
	        this.age = age;
	        this.yearsOfExperience = yearsOfExperience;
	    }

		public int getRetailer_id() {
			return retailer_id;
		}

		public void setRetailer_id(int retailer_id) {
			this.retailer_id = retailer_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public float getYearsOfExperience() {
			return yearsOfExperience;
		}

		public void setYearsOfExperience(float yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}

	    
}
