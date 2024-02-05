import React, { useState } from "react";
import axios from "axios";
import { useEffect } from "react";

export default function DashBoard() {
    const[movies,setMovies] = useState([]);
    const[movie,setMovie]=useState({
        "id":"",
        "movieRank":null ,
        "title": "",
        "description": "",
        "image": "",
        "rating": "",
        "year": null
});

   console.log(movie)

    useEffect(()=>{
        const fetchMovies = async (event) => {
            try {
                const response = await axios.get(`http://ec2-3-216-146-132.compute-1.amazonaws.com:8082/api/v3/movies`,{
                headers: {
                        authorization:`${localStorage.getItem("token")}`
                    }
                });
                setMovies(response.data);
            }catch(error){
                console.error('Error fetching movie data :',error.message);
            }
        };
        fetchMovies();
    },[movie]);

    const handleChange = (event) => {
        // const { name, value } = event.target;
        // setMovie({ ...movie, [name]: value });
    };

    
    const handleWishList=async (e,id,movieRank,title,description,image,rating,year)=> {
        e.preventDefault();
        try {
            const email = localStorage.getItem("email");
            console.log(movie);
            setMovie({...movie,title:title,id:id,movieRank:movieRank,description:description,rating:rating,year:year,image:image});
            const response = await axios.post(`http://ec2-3-216-146-132.compute-1.amazonaws.com:8083/api/v4/wishListService/movie/save?emailId=${email}`,movie,{
            headers: {
                    Authorization:`${localStorage.getItem("token")}`
                }
            });
            console.log(movie);
            console.log(response);
            alert("Movie added to wishlist");
            }catch(error){
            console.error('Error fetching movie data :',error.message);
        }
    };



    return (
        <div>
      <h1>Movies</h1>
      <div style={{ display:'flex', flexWrap:'wrap',justifyContent:'space-evenly',alignItems:'center',height:'100vh' }}>
        {movies && movies.length > 0 ? (
          movies.map((movie) => (
              <div name="id" value={movie.id} onChange={(e) => handleChange(e)} key={movie.id} style={{ border: '1px solid #ddd', padding: '10px',textAlign:'center', marginBottom: '10px', width: '200px',display:'flex',flexDirection:'column' }}>
              <img name="image" value={movie.image} onChange={(e) => handleChange(e)} alt={movie.title} src={movie.image} style={{width:"100%"}} />
              <h3 name="rank" value={movie.rank} onChange={(e) => handleChange(e)}>Rank:{movie.rank}</h3> 
              <h3 name="title" value={movie.title} onChange={(e) => handleChange(e)} style={{marginBottom:'5px',fontSize:'10px',fontWeight:'bold',height:'40px',overflow:'hidden'}}>Title:{movie.title}</h3>
              <p  name="description" value={movie.description} onChange={(e) => handleChange(e)} style={{marginBottom:'10px',fontSize:'14px',height:'60px',overflow:'hidden'}}>
                <span style={{fontWeight:'bold'}}>Description:</span>{movie.description}</p>
              <div style={{ display:'flex',justifyContent:'space-between'}}>
                 <div style={{marginBottom:'10px'}}>
                 <p name="rating" value={movie.rating} onChange={(e) => handleChange(e)} style={{margin:'0',fontSize:'14px'}}>
                    <span style={{fontWeight:'bold'}}>Rating:</span>{movie.rating}</p>
                 <p name="year" value={movie.year} onChange={(e) => handleChange(e)} style={{margin:'0',fontSize:'14px'}}>
                    <span style={{fontWeight:'bold'}}>Year:</span>{movie.year}</p>
                 <button className="btn" style={{marginTop:'10px',background:'#007bff',color:'#fff',border:'none',padding:'5px 10px',cursor:'pointer'}}
                
                 //{setMovie({title:title,id:id,movieRank:movieRank,description:description,rating:rating,year:year,image:image})}
                 onClick={(e,id,movieRank,title,description,image,rating,year)=> handleWishList(e,movie.id,movie.rank,movie.title,movie.description,movie.image,movie.rating,movie.year)} >
                    Add to Wishlist
                    </button>
                    </div>
              </div>
              </div>
          ))
        ) : (
          <p>No movies available.</p>
        )}
      </div>
    </div>
  );
};

               
    
            