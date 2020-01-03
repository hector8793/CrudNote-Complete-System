using NETCORE.Models;
using NETCORE.Services;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace NETCORE.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private readonly UserService _UserService;

        public UsersController(UserService UserService)
        {
            _UserService = UserService;
        }

        [HttpGet]
        public ActionResult<List<User>> Get() =>
            _UserService.Get();

        [HttpGet("{id:length(24)}", Name = "GetUser")]
        public ActionResult<User> Get(string id)
        {
            var User = _UserService.Get(id);

            if (User == null)
            {
                return NotFound();
            }

            return User;
        }

        [HttpPost]
        public ActionResult<User> Create(User User)
        {
            _UserService.Create(User);

            return CreatedAtRoute("GetUser", new { id = User.Id.ToString() }, User);
        }

        [HttpPut("{id:length(24)}")]
        public IActionResult Update(string id, User UserIn)
        {
            var User = _UserService.Get(id);

            if (User == null)
            {
                return NotFound();
            }

            _UserService.Update(id, UserIn);

            return NoContent();
        }

        [HttpDelete("{id:length(24)}")]
        public IActionResult Delete(string id)
        {
            var User = _UserService.Get(id);

            if (User == null)
            {
                return NotFound();
            }

            _UserService.Remove(User.Id);

            return NoContent();
        }
    }
}