import React, { useState, useEffect } from 'react';
import axios from 'axios';
 
const Wishlist = () => {
  const [wishlist, setWishlist] = useState([]);
  const [deleted,setDeleted] =useState(false);

  const isAuthenticated =localStorage.getItem("token") !==null;
 
  useEffect(() => {
    const fetchWishlist = async () => {
      try {
        if(isAuthenticated){
        const email = localStorage.getItem('email');
        const response = await axios.get(`http://ec2-3-216-146-132.compute-1.amazonaws.com:8083/api/v4/wishListService/movies/${email}`, {
          headers: {
            authorization: `${localStorage.getItem('token')}`,
          },
        });
        setWishlist(response.data);
        console.log(response);
    }
      } catch (error) {
        console.error('Error fetching wishlist data: ', error.message);
      }
    };
 
    fetchWishlist();
  }, [isAuthenticated,deleted]);
 
  const handleRemoveFromWishlist = async (id) => {
    try {
        if(isAuthenticated){
      const email = localStorage.getItem('email');
      const response = await axios.delete(`http://ec2-3-216-146-132.compute-1.amazonaws.com:8083/api/v4/wishListService/delete/movie/${id}/${email}`, {
        headers: {
          authorization: `${localStorage.getItem('token')}`,
        },
      });
      //setWishlist(response.data);
      console.log(response.data);
      if(deleted == false){
        setDeleted(true);
      }else {
        setDeleted(false);
      }
      alert('Movie removed from wishlist');
    }
    } catch (error) {
      console.error('Error removing movie from wishlist: ', error.message);
    }
  };
 
  return (
    <div>
      <h1>Wishlist</h1>
      <div style={{ display:'flex', flexWrap:'wrap',justifyContent:'space-evenly',alignItems:'center',height:'100vh' }}>
        {wishlist && wishlist.length > 0 ? (
          wishlist.map((movie) => (
          <div key={movie.id} style={{ border: '1px solid #ddd', padding: '10px',textAlign:'center', marginBottom: '10px', width: '200px',display:'flex',flexDirection:'column' }}>
              <img alt={movie.title} src={movie.image} style={{width:"100%"}} />
              <h3>{movie.rank}</h3>
              <h3 style={{marginBottom:'5px',fontSize:'10px',fontWeight:'bold',height:'40px',overflow:'hidden'}}>Title:{movie.title}</h3>
              <p style={{marginBottom:'10px',fontSize:'14px',height:'60px',overflow:'hidden'}}>
                <span style={{fontWeight:'bold'}}>Description:</span>{movie.description}</p>
              <h3>{movie.rating}</h3>
              <h3>{movie.year}</h3>
              <div style={{ display:'flex',justifyContent:'space-between'}}>
                 <div style={{marginBottom:'10px'}}>
                 <p style={{margin:'0',fontSize:'14px'}}>
                    <span style={{fontWeight:'bold'}}>Rating:</span>{movie.rating}</p>
                 <p style={{margin:'0',fontSize:'14px'}}>
                    <span style={{fontWeight:'bold'}}>Year:</span>{movie.year}</p>
                 <button className="btn" style={{marginTop:'10px',background:'#007bff',color:'#fff',border:'none',padding:'5px 10px',cursor:'pointer'}}
                 onClick={()=>handleRemoveFromWishlist(movie.id)} >
                    Remove from Wishlist
                    </button>
                    </div>
              </div>
              </div>
          ))
        ) : (
          <p>No movies in the wishlist.</p>
        )}
      </div>
    </div>
  );
};
 
export default Wishlist;